CREATE TABLE Users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       full_name VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

CREATE TABLE Flights (
                         flight_id SERIAL PRIMARY KEY,
                         flight_number VARCHAR(255) NOT NULL,
                         airline VARCHAR(255) NOT NULL,
                         origin VARCHAR(255) NOT NULL,
                         destination VARCHAR(255) NOT NULL,
                         departure_time TIMESTAMP NOT NULL,
                         arrival_time TIMESTAMP NOT NULL,
                         price DECIMAL NOT NULL,
                         seats_total INT NOT NULL,
                         seats_available INT NOT NULL
);

CREATE TABLE Bookings (
                          booking_id SERIAL PRIMARY KEY,
                          user_id INT NOT NULL,
                          flight_id INT NOT NULL,
                          booking_time TIMESTAMP NOT NULL,
                          status VARCHAR(50) NOT NULL,
                          payment_status VARCHAR(50) NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES Users(user_id),
                          FOREIGN KEY (flight_id) REFERENCES Flights(flight_id)
);

CREATE TABLE Passengers (
                            passenger_id SERIAL PRIMARY KEY,
                            booking_id INT NOT NULL,
                            first_name VARCHAR(255) NOT NULL,
                            last_name VARCHAR(255) NOT NULL,
                            passport_number VARCHAR(255),
                            special_requests TEXT,
                            FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)
);

CREATE TABLE Payments (
                          payment_id SERIAL PRIMARY KEY,
                          booking_id INT UNIQUE NOT NULL,
                          amount DECIMAL NOT NULL,
                          payment_date TIMESTAMP NOT NULL,
                          payment_method VARCHAR(255) NOT NULL,
                          payment_status VARCHAR(50) NOT NULL,
                          FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id)
);
