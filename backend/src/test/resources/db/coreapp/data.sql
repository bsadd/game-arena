insert into Country
    (code, name)
values
    ('us' , 'United States')
    ,('bd', 'Bangladesh')
;

insert into Game
    (game_name, game_rules, game_icons_location)
values
    ('Tick-Tack-Toe', 'Classic TTT with input being the location of the previous move and output as our next move', 'static_game_files/ttt/files'),
    ('Snake','classic arcade game. Input location of food. Output your next direction','static_game_files/snake/files')
;

insert into Tournament
    (game_id, name, reg_date, start_date, end_date, tournament_rules, sponsor_details)
values
    (1, 'BUET CSE FEST 2023', '2023-06-08','2023-06-10','2023-06-12','Play fair, BUET Students only','DiamondKing'),
    (2, 'Snake fest 2023', '2023-08-08','2023-08-10','2023-08-12','Play fair,Open for all','DiamondKing')
;

insert into Player
    (name, password, profile_pic)
values
    ('Asif haider', '1234', '/static_data/profiles/asif_haider.jpg'),
    ('Ananto', '1234', '/static_data/profiles/ananto.jpg'),
    ('DiamondKing', '1234', '/static_data/profiles/Diamond.jpg')
;

insert into Tournament_Participants
    (player_id, tournament_id)
values 
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2)
;

insert into BotCode
    (player_id, tournament_id, version, codePath, isActive, language)
values
    (1,1,1,'/codes/1/1/code1.c',FALSE, 'C'),
    (1,1,2,'/codes/1/1/code2.c',TRUE, 'C'),
    (2,1,1,'/codes/2/1/code1.cpp',TRUE, 'C++')
;

insert into Match_up
    (tournament_id, player_id1, player_id2, bot_code1, bot_code2, round)
values
    (1,1,2,1,3,'Group');
