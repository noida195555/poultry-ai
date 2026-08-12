-- ============================================================
-- Seed data for Mortality table
-- Hibernate creates the table via ddl-auto=create-drop
-- This file runs after schema creation (defer-datasource-initialization=true)
-- ============================================================

-- Flock 1 — recent week
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (1, 'D501', CURRENT_DATE,          3, 'Disease',   'Birds showed respiratory symptoms before death',      CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (1,'D501', CURRENT_DATE - 1,      5, 'Heat Stress','Temperature exceeded 38°C in the shed',              CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (1,'D501',  CURRENT_DATE - 2,      2, 'Unknown',   'No visible symptoms, found dead in the morning',     CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (1,'D501',  CURRENT_DATE - 3,      1, 'Injury',    'Bird found with broken leg, culled',                 CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (1, 'D501', CURRENT_DATE - 4,      4, 'Disease',   'Suspected Newcastle disease, vet consulted',         CURRENT_TIMESTAMP);

-- Flock 2 — recent week
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (2,'D502',  CURRENT_DATE,          2, 'Heat Stress','Ventilation system malfunction in Block B',          CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (2,'D502',  CURRENT_DATE - 1,      6, 'Disease',   'Coccidiosis outbreak, medication administered',      CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (2,'D502',  CURRENT_DATE - 2,      3, 'Unknown',   'Post-vaccination stress suspected',                  CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (2,'D502',  CURRENT_DATE - 5,      7, 'Predator',  'Night predator breach in eastern pen',               CURRENT_TIMESTAMP);

-- Flock 3 — older records
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (3,'D503',  CURRENT_DATE - 7,      2, 'Disease',   'Mild respiratory infection, treated',                CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (3, 'D503',CURRENT_DATE - 10,    10, 'Heat Stress','Heatwave period, water supply disruption',           CURRENT_TIMESTAMP);
INSERT INTO mortality (flock_id, shed_id, mortality_date, count, cause, notes, recorded_at) VALUES (3,'D503', CURRENT_DATE - 14,     1, 'Injury',    'Bird caught in feeder equipment',                    CURRENT_TIMESTAMP);
