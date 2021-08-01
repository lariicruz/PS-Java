-- Drop table

-- DROP TABLE public.shopping_cart;

CREATE TABLE public.shopping_cart (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	shipping numeric(19,2) NULL,
	status_enum varchar(255) NULL,
	subtotal numeric(19,2) NULL,
	total numeric(19,2) NULL,
	CONSTRAINT shopping_cart_pkey PRIMARY KEY (id)
);
