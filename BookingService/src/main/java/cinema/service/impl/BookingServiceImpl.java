/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.service.impl;

import cinema.model.dao.BookingDao;
import cinema.model.domain.entity.Booking;
import cinema.service.BookingService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookingServiceImpl implements BookingService {

    @Inject
    BookingDao dao;

    @Override
    public Booking getBooking(Long id) {
        return dao.find(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return dao.findAll();
    }
}
