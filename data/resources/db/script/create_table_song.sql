-- run in mysql
show variables like "%time_zone%"; -- check session timezone
set time_zone = '+0:00'; -- update session timezone to UTC

CREATE TABLE `song` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NULL,
    `singer` VARCHAR(50) NULL,
    `type` VARCHAR(45) NULL,
    `album` VARCHAR(50) NULL,
    `pub_date_utc` DATE NULL,
    `rec_cre_dt_utc` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `rec_upd_dt_utc` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);


-- data patch
insert into song(`name`, singer, `type`, album, pub_date_utc) values('sakura', 'いきものがかり', 'POP', 'sakura', '2006-03-15');
insert into song(`name`, singer, `type`, album, pub_date_utc) values('Purple Passion', 'Diana Boncheva', 'INSTRUMENT', 'Beethoven Virus', '2011-04-09');
insert into song(`name`, singer, `type`, album, pub_date_utc) values('芒种', '赵方婧', 'CHINOISERIE', null, '2019-06-06');
insert into song(`name`, singer, `type`, album, pub_date_utc) values('Croatian Rhapsody', 'Maksim Mrvica', 'INSTRUMENT', 'The Piano Player', '2003-12-23');
