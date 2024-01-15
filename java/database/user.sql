-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER edtpa_owner
WITH PASSWORD 'edtpa';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO edtpa_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO edtpa_owner;

CREATE USER edtpa_appuser
WITH PASSWORD 'edtpa';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO edtpa_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO edtpa_appuser;
