-- Insert into category table
INSERT INTO category (id, description, name) VALUES ('category1', 'Computer Keyboards', 'Keyboards');
INSERT INTO category (id, description, name) VALUES ('category2', 'Computer Monitors', 'Monitors');
INSERT INTO category (id, description, name) VALUES ('category3', 'Display Screens', 'Screens');
INSERT INTO category (id, description, name) VALUES ('category4', 'Computer Mice', 'Mice');
INSERT INTO category (id, description, name) VALUES ('category5', 'Computer Accessories', 'Accessories');

-- Insert into product table
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product1', 10, 'Mechanical keyboard with RGB lighting', 'Mechanical Keyboard 1', 99.99, (SELECT id FROM category WHERE name = 'Keyboards'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product2', 15, 'Wireless compact keyboard', 'Wireless Compact Keyboard 1', 79.99, (SELECT id FROM category WHERE name = 'Keyboards'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product3', 20, 'Backlit gaming keyboard with customizable keys', 'Gaming Keyboard 1', 129.99, (SELECT id FROM category WHERE name = 'Keyboards'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product4', 25, 'Mechanical keyboard with wrist rest', 'Ergonomic Keyboard 1', 109.99, (SELECT id FROM category WHERE name = 'Keyboards'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product5', 18, 'Wireless keyboard and mouse combo', 'Wireless Combo 1', 69.99, (SELECT id FROM category WHERE name = 'Keyboards'));

-- Insert into product table for 'Monitors' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product6', 30, '27-inch IPS monitor with 4K resolution', '4K Monitor 1', 399.99, (SELECT id FROM category WHERE name = 'Monitors'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product7', 25, 'Ultra-wide gaming monitor with HDR support', 'Ultra-wide Gaming Monitor 1', 499.99, (SELECT id FROM category WHERE name = 'Monitors'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product8', 22, '24-inch LED monitor for office use', 'Office Monitor 1', 179.99, (SELECT id FROM category WHERE name = 'Monitors'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product9', 28, '32-inch curved monitor with AMD FreeSync', 'Curved Monitor 1', 329.99, (SELECT id FROM category WHERE name = 'Monitors'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product10', 35, 'Portable USB-C monitor for laptops', 'Portable Monitor 1', 249.99, (SELECT id FROM category WHERE name = 'Monitors'));

-- Insert into product table for 'Screens' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product11', 15, 'Curved OLED gaming screen with 240Hz refresh rate', 'Curved OLED Gaming Screen 1', 799.99, (SELECT id FROM category WHERE name = 'Screens'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product12', 18, 'Flat QLED monitor with 1440p resolution', 'QLED Monitor 1', 599.99, (SELECT id FROM category WHERE name = 'Screens'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product13', 22, '27-inch touch screen display for creative work', 'Touch Screen Display 1', 699.99, (SELECT id FROM category WHERE name = 'Screens'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product14', 20, 'Ultra-slim 4K HDR display for multimedia', 'Ultra-slim 4K HDR Display 1', 449.99, (SELECT id FROM category WHERE name = 'Screens'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product15', 25, 'Gaming projector with low input lag', 'Gaming Projector 1', 899.99, (SELECT id FROM category WHERE name = 'Screens'));

-- Insert into product table for 'Mice' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product16', 30, 'Wireless gaming mouse with customizable RGB lighting', 'RGB Gaming Mouse 1', 59.99, (SELECT id FROM category WHERE name = 'Mice'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product17', 28, 'Ergonomic wired mouse for productivity', 'Ergonomic Wired Mouse 1', 29.99, (SELECT id FROM category WHERE name = 'Mice'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product18', 32, 'Ambidextrous gaming mouse with high DPI', 'Ambidextrous Gaming Mouse 1', 69.99, (SELECT id FROM category WHERE name = 'Mice'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product19', 26, 'Travel-sized compact mouse for laptops', 'Travel Mouse 1', 19.99, (SELECT id FROM category WHERE name = 'Mice'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product20', 35, 'Vertical ergonomic mouse for reduced strain', 'Vertical Ergonomic Mouse 1', 39.99, (SELECT id FROM category WHERE name = 'Mice'));

-- Insert into product table for 'Accessories' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product21', 25, 'Adjustable laptop stand with cooling fan', 'Adjustable Laptop Stand 1', 34.99, (SELECT id FROM category WHERE name = 'Accessories'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product22', 20, 'Wireless charging pad for smartphones', 'Wireless Charging Pad 1', 24.99, (SELECT id FROM category WHERE name = 'Accessories'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product23', 28, 'Gaming headset stand with RGB lighting', 'RGB Headset Stand 1', 49.99, (SELECT id FROM category WHERE name = 'Accessories'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product24', 22, 'Bluetooth mechanical keypad for tablets', 'Bluetooth Keypad 1', 39.99, (SELECT id FROM category WHERE name = 'Accessories'));
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES ('product25', 30, 'External hard drive enclosure with USB-C', 'External Hard Drive Enclosure 1', 29.99, (SELECT id FROM category WHERE name = 'Accessories'));
