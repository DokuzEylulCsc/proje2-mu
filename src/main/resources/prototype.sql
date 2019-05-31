INSERT INTO hotels (name, stars) VALUES  ('Hotel Hilton',5);
INSERT INTO hotels (name, stars) VALUES  ('Hotel Swissotel',5);
INSERT INTO hotels (name, stars) VALUES  ('Ramada Plaza',4);
INSERT INTO hotels (name, stars) VALUES  ('Park Inn',4);
INSERT INTO hotels (name, stars) VALUES  ('ibis Hotel',3);
INSERT INTO hotels (name, stars) VALUES  ('Sc Inn Butik',3);
INSERT INTO hotels (name, stars) VALUES  ('Konak Saray Agora',2);
INSERT INTO hotels (name, stars) VALUES  ('Ege Güneş',2);
INSERT INTO hotels (name, stars) VALUES  ('Perla Arya',1);
INSERT INTO hotels (name, stars) VALUES  ('Vita Park',1);
INSERT INTO hotels (name, stars) VALUES  ('Key Hotel',0);
INSERT INTO hotels (name, stars) VALUES  ('Hotel Apart',0);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Visitor Room Type 1',550,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Visitor Room Type 2',500,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Visitor Room Type 3',550,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Visitor Room Type 4',500,0,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Single Bed Room',475,1,0,1,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Executive Suit',2820,1,0,2,1,2,2,2,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),'Presidential Suit',4250,1,1,0,1,3,3,3,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Visitor Room Type 1',600,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Visitor Room Type 2',520,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Visitor Room Type 3',590,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Visitor Room Type 4',530,0,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Single Bed Room',580,1,0,1,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Executive Suit',2850,1,0,2,1,2,2,2,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),'Presidential Suit',4500,1,1,0,1,3,3,3,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),'Visitor Room Type 1',500,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),'Visitor Room Type 2',450,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),'Visitor Room Type 3',500,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),'Visitor Room Type 4',450,0,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),'Single Bed Room',510,1,0,1,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),'Junior Suit',1500,1,1,0,1,2,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Park Inn'),'Visitor Room Type 1',500,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Park Inn'),'Visitor Room Type 2',450,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Park Inn'),'Visitor Room Type 3',500,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Park Inn'),'Visitor Room Type 4',450,0,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Park Inn'),'Single Bed Room',510,1,0,1,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Park Inn'),'Junior Suit',1500,1,1,0,1,2,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),'Standart Room Type 1',475,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),'Standart Room Type 2',425,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),'Standart Room Type 4',425,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),'Standart Room Type 3',475,0,0,2,1,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),'Standart Room Type 1',475,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),'Standart Room Type 2',425,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),'Standart Room Type 4',425,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),'Standart Room Type 3',475,0,0,2,1,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),'Standart Room Type 1',435,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),'Standart Room Type 2',425,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),'Standart Room Type 3',435,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),'Standart Room Type 4',400,0,0,2,1,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),'Standart Room Type 3',375,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),'Standart Room Type 2',350,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),'Standart Room Type 1',375,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),'Standart Room Type 4',350,0,0,2,1,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Perla Arya'),'Standart Room Type 3',175,1,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Perla Arya'),'Standart Room Type 4',150,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Perla Arya'),'Standart Room Type 2',152,1,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Perla Arya'),'Standart Room Type 1',175,0,0,2,1,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Vita Park'),'Standart Room Type 3',125,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Vita Park'),'Standart Room Type 2',100,0,1,0,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Vita Park'),'Standart Room Type 1',125,0,0,2,1,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Vita Park'),'Standart Room Type 4',100,0,0,2,1,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Key Hotel'),'Standart Room Type 3',100,0,1,0,0,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Key Hotel'),'Standart Room Type 2',90,0,1,0,0,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Key Hotel'),'Standart Room Type 1',100,0,0,2,0,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Key Hotel'),'Standart Room Type 4',90,0,0,2,0,1,1,1,null);

INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),'Standart Room Type 3',90,0,1,0,0,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),'Standart Room Type 2',75,0,1,0,0,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),'Standart Room Type 1',90,0,0,2,0,1,1,1,null);
INSERT INTO room_type (hotel_id, type_name, price, sea_view, double_bed, single_bed, safe, air_conditioner_count, minibar_count, television_count, extra_services_description)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),'Standart Room Type 4',75,0,0,2,0,1,1,1,null);

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),001,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),002,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),003,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),004,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),005,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),006,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),007,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),008,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),009,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),010,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),101,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),102,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),103,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),104,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),105,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),106,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),107,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
 VALUES ((SELECT id from hotels where name ='Hotel Hilton'),108,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),109,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),110,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),201,(SELECT id FROM room_type WHERE type_name='Executive Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),202,(SELECT id FROM room_type WHERE type_name='Executive Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),203,(SELECT id FROM room_type WHERE type_name='Executive Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),301,(SELECT id FROM room_type WHERE type_name='Presidential Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Hilton'),302,(SELECT id FROM room_type WHERE type_name='Presidential Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Hilton')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),001,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),002,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),003,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),004,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),005,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),006,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),007,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),008,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),009,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),010,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),101,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),102,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),103,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),104,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),105,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),106,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),107,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),108,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),109,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),110,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),201,(SELECT id FROM room_type WHERE type_name='Executive Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),202,(SELECT id FROM room_type WHERE type_name='Executive Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),203,(SELECT id FROM room_type WHERE type_name='Executive Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),301,(SELECT id FROM room_type WHERE type_name='Presidential Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Swissotel'),302,(SELECT id FROM room_type WHERE type_name='Presidential Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Swissotel')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),001,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),002,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),003,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),004,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),005,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),006,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),007,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),008,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),009,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),010,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),101,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),102,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),103,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),104,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),105,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),106,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),107,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),108,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),109,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),110,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),201,(SELECT id FROM room_type WHERE type_name='Junior Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),202,(SELECT id FROM room_type WHERE type_name='Junior Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ramada Plaza'),203,(SELECT id FROM room_type WHERE type_name='Junior Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Ramada Plaza')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),001,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),002,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),003,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),004,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),005,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),006,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),007,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),008,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),009,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),010,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),101,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),102,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),103,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),104,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),105,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),106,(SELECT id FROM room_type WHERE type_name='Single Bed Room' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),107,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),108,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),109,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),110,(SELECT id FROM room_type WHERE type_name='Visitor Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),201,(SELECT id FROM room_type WHERE type_name='Junior Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),202,(SELECT id FROM room_type WHERE type_name='Junior Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Park Inn'),203,(SELECT id FROM room_type WHERE type_name='Junior Suit' AND room_type.hotel_id=(SELECT id from hotels where name ='Park Inn')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),007,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),008,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),009,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),106,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),107,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),108,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),109,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='ibis Hotel'),110,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='ibis Hotel')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),007,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),008,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),009,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),106,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),107,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),108,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),109,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Sc Inn Butik'),110,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Sc Inn Butik')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),007,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),008,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),009,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Konak Saray Agora'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Konak Saray Agora')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),007,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),008,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),009,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Ege Güneş'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Ege Güneş')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),007,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),008,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),009,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Perla Arya'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Perla Arya')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),007,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),008,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),009,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Vita Park'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Vita Park')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Key Hotel'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Key Hotel')));

INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),001,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),002,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),003,(SELECT id FROM room_type WHERE type_name='Standart Room Type 3' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),004,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),005,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),006,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),010,(SELECT id FROM room_type WHERE type_name='Standart Room Type 2' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),101,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),102,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),103,(SELECT id FROM room_type WHERE type_name='Standart Room Type 1' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),104,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));
INSERT INTO rooms (hotel_id, room_number, room_type_id)
VALUES ((SELECT id from hotels where name ='Hotel Apart'),105,(SELECT id FROM room_type WHERE type_name='Standart Room Type 4' AND room_type.hotel_id=(SELECT id from hotels where name ='Hotel Apart')));

INSERT INTO accounts (email, password_hash, name, admin) VALUES ('egiman@catmail.com',1216985755,'Egi',0);
INSERT INTO accounts (email, password_hash, name, admin) VALUES ('mertdede@protonmail.com',1216985755,'Mert',1);
INSERT INTO accounts (email, password_hash, name, admin) VALUES ('ulugbey@hotmail.com',1216985755,'Ulugbey',1);
INSERT INTO accounts (email, password_hash, name, admin) VALUES ('kestos@catmail.com',1216985755,'Kestane',0);
INSERT INTO accounts (email, password_hash, name, admin) VALUES ('cumali@hotmail.com',1216985755,'Cumali',0);
INSERT INTO accounts (email, password_hash, name, admin) VALUES ('remzi@gmail.com',1216985755,'Remziye',0);
INSERT INTO accounts (email, password_hash, name, admin) VALUES ('kuzukuzu@yahoo.com',1216985755,'Tarkan',0);

INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (1,(SELECT id FROM accounts WHERE email='egiman@catmail.com'),1,'2019-06-04','2019-06-09');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (2,(SELECT id FROM accounts WHERE email='egiman@catmail.com'),2,'2019-12-04','2019-12-06');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (3,(SELECT id FROM accounts WHERE email='kestos@catmail.com'),2,'2019-07-15','2019-07-17');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (4,(SELECT id FROM accounts WHERE email='kestos@catmail.com'),1,'2019-11-02','2019-11-05');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (24,(SELECT id FROM accounts WHERE email='cumali@hotmail.com'),1,'2020-01-12','2019-01-14');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (25,(SELECT id FROM accounts WHERE email='cumali@hotmail.com'),1,'2020-01-12','2019-01-14');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (29,(SELECT id FROM accounts WHERE email='remzi@gmail.com'),1,'2019-08-12','2019-01-13');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (28,(SELECT id FROM accounts WHERE email='remzi@gmail.com'),1,'2020-05-12','2019-06-13');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (51,(SELECT id FROM accounts WHERE email='kuzukuzu@yahoo.com'),1,'2019-09-21','2019-09-25');
INSERT INTO reservations (room_id, account_id, person_count, start_date, end_date)
VALUES (36,(SELECT id FROM accounts WHERE email='kuzukuzu@yahoo.com'),1,'2020-04-27','2019-05-02');