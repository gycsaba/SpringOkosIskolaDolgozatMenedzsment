CREATE TABLE IF NOT EXISTS dolgozatok (
  id VARCHAR(10) PRIMARY KEY,
  nev VARCHAR(64) NOT NULL,
  leiras CLOB,
  megirva BOOLEAN DEFAULT FALSE,
  letrehozasDatuma DATE NOT NULL,
  dolgozatirasDatuma DATE NOT NULL
);

CREATE INDEX IF NOT EXISTS dolgozatok_letrehozasDatuma ON dolgozatok (letrehozasDatuma);