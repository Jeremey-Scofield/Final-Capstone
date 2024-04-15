BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,email, role) VALUES ('user1','user1','user1@email.com','ROLE_USER');
INSERT INTO users (username,password_hash,email, role) VALUES ('user2','user2','user2@email.com','ROLE_USER');
INSERT INTO users (username,password_hash,email, role) VALUES ('user3','user3','user3@email.com','ROLE_USER');

INSERT INTO public.collections(collection_name, user_id) VALUES ('collection1', 1);
INSERT INTO public.collections(collection_name, user_id) VALUES ('collection2', 2);
INSERT INTO public.collections(collection_name, user_id) VALUES ('collection3', 2);
INSERT INTO public.collections(collection_name, user_id) VALUES ('collection4', 3);
INSERT INTO public.collections(collection_name, user_id) VALUES ('collection5', 3);
INSERT INTO public.collections(collection_name, user_id) VALUES ('collection6', 3);

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (1, '151cafcb-a589-4681-a914-7313246a7626');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (1, 'a37159df-f6d7-4db6-85de-0ea77f425993');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (1, '89ca686a-7c72-4d8f-9290-e89635624a83');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '7f394a7b-6945-45c8-ad2f-f761150c856a');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '10ab3102-43a3-4c60-8641-2c5a7c1e29c2');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, 'c6861c50-d336-4352-a76d-ec22a86ec09e');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '1a587b8d-fcb4-47ca-9689-610897117166');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '29e1c6e3-d76e-4388-b4e9-f732fdec4338');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, 'dc3b2bab-755d-4b2f-97c0-70a74d721a79');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '79e91e8a-cee7-411b-b0a3-d3383c0d4a43');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '26f6170a-34dc-41c8-b3b1-20377f131e6e');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, 'b953d19f-6ba7-4aee-b353-c60dc9572610');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, 'fa023c32-2cec-416c-90b7-07b7a19c82d4');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (4, '41dd29b9-f08d-4ccc-8dc0-da11d2d456e9');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (4, '5089ec1a-f881-4d55-af14-5d996171203b');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (4, 'c0a448ee-e5f9-4e57-85b0-f6d401018170');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '4a3cc4f6-037f-461d-a3b7-9f9e24c4b8cf');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '0b88bc94-99c4-4be5-b474-a7dad68057b3');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '514179c0-a50b-4565-8e71-9dad256edd85');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'eb44b65d-6b56-4f20-a4fb-c5dd147a54c4');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '624d4bda-448f-43d1-92b6-53a77afe2374');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'a6a9776b-87f4-4a08-8074-d49fbbe417ae');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '55f3c721-e13a-406e-bc8e-d6cdc91ac477');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'a6708b11-1bcd-4208-a967-fe91f2e3313c');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '5c4e9401-537c-4bf6-bd07-d2abc43612c9');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'a64656b2-0f0c-4239-9dfe-a9ddc7ada733');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '895527a6-e3b2-454d-a3be-c0036630ec73');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '8fd85a54-f0c7-4e9f-a4b4-b9b513b98d95');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'c6a4a39e-87e6-47bd-bbe3-ca3c98c2049c');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '8f6a2fce-719e-4745-80d3-aabce5c9bafa');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '1869a326-8b48-4331-b969-5ce83cf4ff8a');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '2c63e4e1-89d2-4bc6-a232-94e75c4b1c8a');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'b9d018ff-de27-4bf6-9cc6-9d9a46db3eb9');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '562d71b9-1646-474e-9293-55da6947a758');


COMMIT TRANSACTION;
