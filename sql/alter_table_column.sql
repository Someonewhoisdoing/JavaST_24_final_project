ALTER TABLE menu_item
RENAME COLUMN ingredient_id TO ingredient_name;

ALTER TABLE ingredient
RENAME COLUMN name TO name_list;

ALTER TABLE menu_item DROP CONSTRAINT fk_menu_item_ingredient;
