drop table if exists Country;
create TABLE Country (
  id INT NOT NULL AUTO_INCREMENT,
  code char(3) NOT NULL,
  name varchar(20) NOT NULL,
  PRIMARY KEY (id)
);

drop table if exists Game;
create TABLE Game(
  id INT NOT NULL AUTO_INCREMENT primary key,
  game_name varchar(64) unique ,
  game_rules varchar(512),
  game_icons_location varchar(128)
);

drop table if exists Tournament;
create TABLE Tournament(
  id int not null auto_increment primary key,
  game_id int not null references Game(id),
  name varchar(64) unique ,
  reg_date datetime not null,
  start_date datetime not null,
  end_date datetime not null,
  tournament_rules varchar(512),
  sponsor_details varchar(512)
);

drop table if exists Player;
create TABLE Player(
  id int not null auto_increment primary key,
  name varchar(64) not null,
  password varchar(64) not null,
  profile_pic varchar(64) not null
);

drop table if exists Tournament_Participants;
create table Tournament_Participants(
  player_id int not null references Player(id),
  tournament_id int not null references Tournament(id)
);

drop table if exists BotCode;
create table BotCode(
  id int not null auto_increment primary key ,
  player_id int not null references Player(id),
  tournament_id int not null references Tournament(id),
  version int not null,
  codePath varchar(64) not null unique,
  isActive boolean default FALSE,
  language varchar(16),
  UNIQUE KEY (player_id, tournament_id, version)
);

drop table if exists Match_up;
create table Match_up(
  id int not null auto_increment primary key,
  tournament_id int not null references Tournament(id),
  player_id1 int not null references Player(id),
  player_id2 int not null references Player(id),
  bot_code1 int not null references BotCode(id),
  bot_code2 int not null references BotCode(id),
  game_moves_json varchar(64),
  result varchar(64),
  winner_player_id int references Player(id),
  round varchar(16) not null
);

