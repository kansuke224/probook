-- CREATE SEQUENCE probook.AUTONUMBER_SEQ;

-- ���ԗp�g���K�[
CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING
BEFORE INSERT ON users
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.user_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.user_id := USERID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;






CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING_BOOK
BEFORE INSERT ON book
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.book_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.book_id := BOOKID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;





CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING_GENRE
BEFORE INSERT ON genre
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.genre_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.genre_id := GENREID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;





CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING_BUY_AFTER
BEFORE INSERT ON buy_after
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.buy_after_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.buy_after_id := BUY_AFTERID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;





CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING_POINT
BEFORE INSERT ON point
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.point_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.point_id := POINTID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;





CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING_PURCHASE
BEFORE INSERT ON purchase
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.purchase_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.purchase_id := PURCHASEID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;





CREATE OR REPLACE TRIGGER probook.AUTONUMBER_NUMBERING_REVIEW
BEFORE INSERT ON review
FOR EACH ROW
DECLARE
    eIKENAIYO        EXCEPTION;
    -- (�I�v�V����) ��O�̕t���ւ� DUP_VAL_ON_INDEX
    PRAGMA EXCEPTION_INIT(eIKENAIYO, -1);
BEGIN
    IF (:NEW.review_id IS NOT NULL) THEN
        RAISE eIKENAIYO;
    END IF;
    -- Oracle 11g �ȍ~
    :NEW.review_id := REVIEWID_SEQ.NEXTVAL ;
    -- Oracle 11g ���O
    -- SELECT AUTONUMBER_SEQ.NEXTVAL INTO :NEW.SEQ_NO FROM DUAL ;
END;

