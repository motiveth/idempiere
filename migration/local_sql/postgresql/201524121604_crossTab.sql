CREATE EXTENSION IF NOT EXISTS tablefunc;
SELECT register_migration_script('201524121604_crossTab.sql') FROM dual
;
