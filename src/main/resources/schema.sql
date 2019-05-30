CREATE TABLE hotels (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    stars INTEGER NOT NULL CHECK( stars >= 0 )
);

CREATE TABLE room_type (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    hotel_id INTEGER NOT NULL ,
    type_name TEXT NOT NULL,

    -- description of service
    price INTEGER NOT NULL CHECK( price > 0 ),
    sea_view INTEGER DEFAULT 0 NOT NULL CHECK( sea_view IN (0, 1) ),
    double_bed INTEGER DEFAULT 0 NOT NULL CHECK( double_bed >= 0 ),
    single_bed INTEGER DEFAULT 0 NOT NULL CHECK( single_bed >= 0 ),
    safe INTEGER DEFAULT 0 NOT NULL CHECK( safe IN (0, 1) ),
    air_conditioner_count INTEGER DEFAULT 0 NOT NULL CHECK( air_conditioner_count >= 0 ),
    minibar_count INTEGER DEFAULT 0 NOT NULL CHECK( minibar_count >= 0),
    television_count INTEGER DEFAULT 0 NOT NULL CHECK( television_count >= 0),
    extra_services_description TEXT,

    FOREIGN KEY (hotel_id) REFERENCES hotels (id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION,
    UNIQUE(hotel_id, type_name)
);

CREATE TABLE rooms (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    hotel_id INTEGER NOT NULL,
    room_number INTEGER NOT NULL,
    room_type_id INTEGER NOT NULL,

    FOREIGN KEY (hotel_id) REFERENCES hotels (id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION,

    FOREIGN KEY (room_type_id) REFERENCES room_type (id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION
);

CREATE TABLE reservations (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    room_id INTEGER NOT NULL,
    account_id INTEGER NOT NULL,
    person_count INTEGER DEFAULT 1 NOT NULL CHECK( person_count > 0 ),

    -- format is ISO8601, ex. '2019-06-06', thus length should be 10
    start_date TEXT NOT NULL CHECK( length(start_date) ==  10 ),
    end_date TEXT NOT NULL CHECK( length(end_date) ==  10 ),

    FOREIGN KEY (room_id) REFERENCES rooms (id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION,

    FOREIGN KEY (account_id) REFERENCES accounts (id)
        ON DELETE CASCADE
        ON UPDATE NO ACTION
);

CREATE TABLE accounts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    email TEXT NOT NULL,
    password_hash INTEGER NOT NULL,
    name TEXT NOT NULL,
    admin INTEGER DEFAULT 0 NOT NULL CHECK( admin IN (0, 1) )
);


CREATE INDEX email_idx ON accounts (email);
CREATE INDEX admin_idx ON accounts (admin);
CREATE INDEX room_type_hotel_id_fkey_idx ON room_type (hotel_id);
CREATE INDEX rooms_hotel_id_idx ON rooms (hotel_id);
CREATE INDEX reservations_room_id_fkey_idx ON reservations (room_id);
CREATE INDEX reservations_start_date_idx ON reservations (start_date);
CREATE INDEX reservations_end_date_idx ON reservations (end_date);
