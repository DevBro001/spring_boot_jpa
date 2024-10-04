create or replace function function1()
    returns int
    language plpgsql as
    $$
        BEGIN
            RETURN 1+2;
        END;
    $$