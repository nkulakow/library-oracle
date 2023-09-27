CREATE OR REPLACE TRIGGER check_phone_number
BEFORE INSERT OR UPDATE ON employees

BEGIN

    IF LEN(:new.phone_number) = 9 THEN
        CONCAT('+48', :new.phone_number);
    END IF;
    IF LEN(:new.phone_number) != 12 OR LEFT(:new.phone_number, 3) != '+48' THEN
        raise_application_error(-20001, 'error with the phone number');
    END IF;
    dbms_output.put_line('phone_number added correctly');
END;
