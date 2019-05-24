CREATE TABLE Hotels (
    hotel_id INTEGER NOT NULL UNIQUE PRIMARY KEY ,
    hotel_name TEXT NOT NULL ,
    discount_percentage INTEGER NOT NULL CHECK(0 <= discount_percentage <= 100)
);


CREATE TABLE Rooms (
    room_id INTEGER NOT NULL,
    hotel_id INTEGER NOT NULL,
    room_type TEXT NOT NULL ,
    sea_view INTEGER DEFAULT 0 NOT NULL CHECK( sea_view IN (0, 1) ),
    double_bed INTEGER DEFAULT 0 NOT NULL CHECK ( double_bed >= 0 ),
    single_bed INTEGER DEFAULT 0 NOT NULL CHECK ( single_bed >= 0 ),
    safe INTEGER DEFAULT 0 NOT NULL CHECK ( safe IN (0, 1) ),

    air_conditioner_count INTEGER DEFAULT 0 NOT NULL CHECK ( air_conditioner_count >= 0 ),
    minibar_count INTEGER DEFAULT 0 NOT NULL CHECK ( minibar_count >= 0),
    television_count INTEGER DEFAULT 0 NOT NULL CHECK ( television_count >= 0),
    extra_services_description TEXT,

    PRIMARY KEY (room_id, hotel_id),
    FOREIGN KEY (hotel_id) REFERENCES Hotels (hotel_id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION
);

CREATE TABLE Reservations (
    hotel_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,

    -- format is ISO8601, ex. '2019-06-06', thus length should be 10
    start_date TEXT NOT NULL CHECK(length(start_date) ==  10),
    end_date TEXT NOT NULL CHECK(length(start_date) ==  10),

    PRIMARY KEY (hotel_id, room_id, start_date),
    FOREIGN KEY (hotel_id, room_id) REFERENCES Rooms (hotel_id, room_id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION
);


CREATE TABLE Accounts (
    account_id INTEGER UNIQUE NOT NULL PRIMARY KEY ,
    account_password_hash TEXT DEFAULT '' NOT NULL ,
    real_name TEXT NOT NULL,
    admin INTEGER DEFAULT 0 NOT NULL CHECK (admin IN (0, 1) )
);
