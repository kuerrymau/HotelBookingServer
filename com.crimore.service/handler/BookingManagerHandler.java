package com.crimore.service.booking.impl;

import org.apache.thrift.TException;
import com.crimore.domain.booking.Booking;
import com.crimore.domain.booking.BookingRoom;
import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.Hotel;
import com.crimore.domain.hotel.HotelType;
import com.crimore.domain.hotel.RoomType;
import com.crimore.domain.location.Location;
import com.crimore.entitymanager.EntityManagerImpl;
import com.crimore.service.booking.BookingManager;
import com.crimore.service.booking.ReservationHistory;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public class BookingManagerHandler implements BookingManager.Iface {
    static Logger log = Logger.getLogger(BookingManagerHandler.class);
    private EntityManager entityManager = EntityManagerImpl.getEntityManager();

    @Override
    public Booking makeABooking(Hotel hotel,
                                Date arrivalDate,
                                Date departureDate,
                                Guest guest,
                                RoomType roomType) throws TException {
        Booking booking = new Booking(hotel, arrivalDate, departureDate, guest);
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(booking);
            entityManager.getTransaction().commit();

            makeBookingRoom(roomType, booking, guest);
            ReservationHistory.reservationsForGuest.add(booking);

        } catch (Exception e) {
            log.error("Exception occurred creating booking, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return booking;
    }

    @Override
    public void cancelABooking(Booking booking) throws TException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(booking);
            entityManager.getTransaction().commit();

            deleteBookingRoom(booking);
            ReservationHistory.reservationsForGuest.remove(booking);
        } catch (Exception e) {
            log.error("Exception occurred deleting booking, " + e);
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void updateBooking(Booking booking) throws TException {
        try {
            entityManager.getTransaction().begin();
            booking = (Booking) entityManager.find(Booking.class, booking.getId());
            entityManager.merge(booking);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred updating booking, " + e);
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void deleteBookingRoom(Booking booking) throws TException {
        try {
            entityManager.getTransaction().begin();
            BookingRoom bookingRoom = (BookingRoom) entityManager.find(BookingRoom.class, booking.getId());
            entityManager.remove(bookingRoom);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred deleting bookingRoom, " + e);
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public BookingRoom makeBookingRoom(RoomType roomType, Booking booking, Guest guest) throws TException {
        BookingRoom bookingRoom = new BookingRoom(roomType, booking, guest);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bookingRoom);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred creating bookingRoom, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return bookingRoom;
    }

    @Override
    public Hotel createHotel(String name, Location location, HotelType hotelType) throws TException {
        Hotel hotel = new Hotel(name, location, hotelType);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(hotel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred creating hotel, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return hotel;
    }

    @Override
    public Location createLocation(String name) throws TException {
        Location location = new Location(name);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(location);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred creating location, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return location;
    }

    @Override
    public HotelType createHotelType(String hotelTypeName) throws TException {
        HotelType hotelType = new HotelType(hotelTypeName);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(hotelType);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred creating hotelType, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return hotelType;
    }

    @Override
    public RoomType createRoomType(String name,
                                   Hotel hotel,
                                   float roomRatePerDay,
                                   int maxNumberOfPeople) throws TException {
        RoomType roomType = new RoomType(name, hotel, roomRatePerDay, maxNumberOfPeople);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(roomType);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred creating roomType, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return roomType;
    }

    @Override
    public Guest createGuest(String firstName, String surname) throws TException {
        Guest guest = new Guest(firstName, surname);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(guest);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception occurred creating guest, " + e);
            entityManager.getTransaction().rollback();
            return null;
        }
        return guest;
    }

    @Override
    public List<RoomType> findAvailableRoomsInLocation() throws TException {
        TypedQuery<RoomType> query = entityManager.createNamedQuery("RoomType.findAvailableRooms", RoomType.class);
        return java.util.Collections.unmodifiableList((List<RoomType>) query.getResultList());
    }
}
