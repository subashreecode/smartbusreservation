insert into route (id, source, destination,distance_km)
values(1,'Dublin','Cork',260),
(2,'Dublin','Galway',210),
(3,'Cork','Limerick',100)

insert into bus(id, bus_number,operator_name,departure_time,arrival_time,price,rating,route_id)
values(1,'DB101', 'Dublin Express', '08:00:00', '12:00:00', 25.00, 4.5, 1),
(2,'DB102', 'Dublin Express', '10:00:00', '14:00:00', 27.00, 4.2, 1),
(3,'GL201', 'GoBus', '09:00:00', '12:30:00', 22.00, 4.7, 2);
commit;
