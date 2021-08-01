-- Drop table

-- DROP TABLE public.item;

CREATE TABLE public.item (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	price numeric(19,2) NULL,
	product_id int8 NULL,
	shopping_cart_id int8 NULL,
	itens_id int8 NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id),
	CONSTRAINT fkb4v596wqde51kaljt9epgnyaq FOREIGN KEY (shopping_cart_id) REFERENCES public.shopping_cart(id),
	CONSTRAINT fkconl4l7ygbny6fv8ppqdvg5il FOREIGN KEY (itens_id) REFERENCES public.shopping_cart(id),
	CONSTRAINT fkd1g72rrhgq1sf7m4uwfvuhlhe FOREIGN KEY (product_id) REFERENCES public.product(id)
);