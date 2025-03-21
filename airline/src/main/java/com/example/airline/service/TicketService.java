package com.example.airline.service;

import com.example.airline.exception.ResourceNotFoundException;
import com.example.airline.model.Ticket;
import com.example.airline.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        // Add validation for duplicate seat numbers, etc.
        if (ticket.getPassengerName() == null || ticket.getPassengerName().trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger name cannot be empty");
        }
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}