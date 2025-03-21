-- src/main/resources/data.sql

-- Insert Flights
INSERT INTO flight (flight_number, origin, destination) VALUES
('AA101', 'New York', 'Los Angeles'),
('AA102', 'Chicago', 'Miami'),
('AA103', 'Dallas', 'Seattle');

-- Insert Schedules
INSERT INTO schedule (flight_id, departure_time, arrival_time) VALUES
(1, '2025-03-21 08:00:00', '2025-03-21 11:00:00'),
(1, '2025-03-21 14:00:00', '2025-03-21 17:00:00'),
(2, '2025-03-21 09:00:00', '2025-03-21 11:30:00'),
(3, '2025-03-21 10:00:00', '2025-03-21 13:30:00');

-- Insert Tickets
INSERT INTO ticket (passenger_name, seat_number, schedule_id) VALUES
('John Doe', 'A1', 1),
('Jane Smith', 'B2', 1),
('Bob Johnson', 'C3', 2);