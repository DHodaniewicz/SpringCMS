use cms;

INSERT INTO authors (id, firstName, lastName) values (1, 'John', 'Doe'),
                                                 (2, 'Peter', 'Morgan'),
                                                 (3, 'Dean', 'Smith'),
                                                 (4, 'Peter', 'Jackson');

INSERT INTO categories (id, description, name) values (1, 'historical facts', 'history'),
                                                  (2, 'scores and other stuff', 'sport'),
                                                  (3, 'newest gossips', 'celebrities');

INSERT INTO articles (id, content, crated, title, updated, author_id) values
                      (1, 'some content', '2022-09-03T18:30.22.123', 'some title','2022-09-03T18:30.22.123', 1 ),
                      (2, 'some content2', '2022-09-03T18:32.22.123', 'some title2','2022-09-03T18:32.22.123', 2 );

INSERT INTO articles_categories (articles_id, categories_id) VALUES (1,1), (2,3);


