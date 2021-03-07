DROP TABLE IF EXISTS movie;

CREATE TABLE movie (
  id UUID PRIMARY KEY,
  title TEXT NOT NULL,
  overview TEXT NOT NULL,
  poster TEXT NOT NULL,
  vote_average INT NOT NULL,
  release_date TIMESTAMP WITHOUT TIME ZONE NOT NUlL
);

INSERT INTO movie (id, title, overview, poster, vote_average, release_date) VALUES
  ('52a5d2b2-31b7-489f-bd54-f307924ce537', 'Its okay to be not okay', 'Ko Moon Young is heart', 'IOTBNO test poster', 95, '2021-03-08 20:19:31.664'),
  ('4ed4d85c-56b5-4503-bcbd-d32888ce7351', 'Itaewon Class', 'Soo-A ftw', 'IC test poster', 98, '2021-02-08 20:19:31.664'),
  ('5bb4d65f-9570-43f4-9016-732c77b8eb96', 'StartUp', 'Suzy is heart', 'StartUp test poster', 90, '2021-01-08 20:19:31.664')
