BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,email, role) VALUES ('jeffery','$2a$10$JPpiS.G2ofm1rfFXqurdcuMxEz6oYVupXpXeHSrDOTDKkfiLFm4F6','user1@email.com','ROLE_USER');
INSERT INTO users (username,password_hash,email, role) VALUES ('bob','$2a$10$JPpiS.G2ofm1rfFXqurdcuMxEz6oYVupXpXeHSrDOTDKkfiLFm4F6','user2@email.com','ROLE_USER');
INSERT INTO users (username,password_hash,email, role) VALUES ('samantha','$2a$10$JPpiS.G2ofm1rfFXqurdcuMxEz6oYVupXpXeHSrDOTDKkfiLFm4F6','user3@email.com','ROLE_USER');

INSERT INTO public.collections(collection_name, user_id) VALUES ('the black deck', 1);
INSERT INTO public.collections(collection_name, user_id) VALUES ('bobs favs', 2);
INSERT INTO public.collections(collection_name, user_id) VALUES ('we winnin', 2);
INSERT INTO public.collections(collection_name, user_id) VALUES ('sams cards', 3);
INSERT INTO public.collections(collection_name, user_id) VALUES ('personal favs!', 3);
INSERT INTO public.collections(collection_name, user_id) VALUES ('Angels & Dragons', 3);

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (1, '27180bad-9bbc-462b-8832-626dc403a3fd');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (1, '3b945b4d-5240-4779-9187-e3b18903bf59');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (1, 'e61f8b36-6ad2-4295-bd1d-7f9e90b23190');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '5d095694-9016-4b1b-81d0-ffa1fc7662a3');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '35f1a6ba-e46f-44fb-93f4-fb883d677b36');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '168cbca9-0124-478b-8dd7-0bd9dc711c6d');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '307bef28-eb1d-4f43-bc76-304e027ba453');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (2, '9f65422e-2da5-4eb9-bed6-090d7e2de498');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '4234e98b-c89c-4169-bddc-141cc1ba363d');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '74db0dd4-3bb6-41f7-803c-a04647327dec');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '089b1057-ed1f-45a5-ba95-28aa51713764');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '93311f80-0d0e-4005-ba43-5dbfe438d127');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (3, '96b263fb-00b5-4050-85e1-cfc4018bb75d');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (4, '41ac1aa0-c350-4c77-ac3a-2c5abfcb7e35');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (4, '9dcfcd37-7c54-415e-86d0-6763bd71e209');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (4, '3f47b0c5-f1d9-46a6-8fc5-c12db4fb1c88');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '7aede682-c5a1-486e-ae61-017f99aed5b0');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'c56c3800-b6d5-44e8-8797-2d80070fd4d0');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '419fea28-3813-4e65-8b90-6d335fdf0a0b');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'b00e61dc-0e8d-4015-b343-d487e6a7a95c');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'cb0e4c78-75fe-4692-b177-974b148f0614');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '85b64d1f-29f4-4165-b81c-a831dd051139');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, 'a1ea2c17-382a-45e4-ac34-88bf8ba47169');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (5, '35b3ad6b-9966-489f-a4c9-2639a634fd62');

INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'a835da43-0a3e-40fb-a7e8-4fa118c7d975');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'de6ff6af-22f4-46fb-97d3-6f8f20f8b16c');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'b5fb67ed-f4ea-47d6-876a-2ad6a3fc9a18');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'b43b3c33-aa44-4001-87ff-695bf04f51be');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'd094541b-855c-4e4f-a024-cab735987787');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'a30c266d-579e-4757-a4d6-6722fa343a6');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'eb5beaf0-21ca-4539-8773-8a9430af74b0');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '94d0e916-26c5-4a27-9ea5-69120160b25b');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, 'a79701b4-d220-4c3e-b96c-7a77a22ba899');
INSERT INTO public.collection_cards(collection_id, card_id) VALUES (6, '2860a20d-e1bf-4e46-8c07-a858f616d5a5');


COMMIT TRANSACTION;
