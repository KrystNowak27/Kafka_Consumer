
ALTER TABLE personality
ADD COLUMN created_at TIMESTAMP;

UPDATE personality
SET created_at = CURRENT_TIMESTAMP;

ALTER TABLE personality
ALTER COLUMN created_at SET NOT NULL;

select * from personality;