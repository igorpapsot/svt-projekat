
insert into user (user_id ,user_username, user_password, user_email, user_avatar, user_registration_date, user_is_banned) values ('1', 'Marko', '12345', 'marko@gmail.com', 'avatarFilm',  '2020-3-3', false);

insert into flair values(1, "cars");
insert into flair values(2, "animals");
insert into flair values(3, "outdoors");

insert into post values(1, "2022-5-5", "image-path", "New text about cars", "Suzuki new car", 1, 1);
insert into post values(2, "2022-2-5", "image-path1", "New text about animals", "Penguins", 2, 1);
insert into post values(3, "2022-2-3", "image-path2", "New text about outdoors activity", "Hiking", 3, 1);