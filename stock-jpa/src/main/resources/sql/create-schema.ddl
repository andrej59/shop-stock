/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT (ID NUMERIC(12) IDENTITY not null, TYPE_ID NUMERIC(12) not null, NAME VARCHAR(256) not null, PRICE NUMERIC(10,2) not null, STATUS_ID NUMERIC(12) not null, DESCRIPTION VARCHAR(4000) null, constraint PK_PRODUCT primary key (ID));

comment on table PRODUCT is 'Продукт магазина';

comment on column PRODUCT.ID is 'Идентификатор продкута';

comment on column PRODUCT.TYPE_ID is 'Тип продукта';

comment on column PRODUCT.NAME is 'Наименование продукта';

comment on column PRODUCT.PRICE is 'Цена продукта';

comment on column PRODUCT.STATUS_ID is 'Статус продукта';

comment on column PRODUCT.DESCRIPTION is 'Описание продукта';

/*==============================================================*/
/* Table: SP_COLOR                                              */
/*==============================================================*/
create table SP_COLOR (ID NUMERIC(12) not null, NAME VARCHAR(128) not null, IDENT VARCHAR(32) not null, constraint PK_SP_COLOR primary key (ID), constraint UK1_SP_COLOR unique (IDENT));

comment on table SP_COLOR is 'Справочник цвета';

comment on column SP_COLOR.ID is 'Идентификатор цвета';

comment on column SP_COLOR.NAME is 'Наименование цвета';

comment on column SP_COLOR.IDENT is 'Строковый идентификатор цвета';

/*==============================================================*/
/* Table: SP_PRODUCT_STATUS                                     */
/*==============================================================*/
create table SP_PRODUCT_STATUS (ID NUMERIC(12) not null, NAME VARCHAR(64) not null, IDENT VARCHAR(32) not null, constraint PK_SP_PRODUCT_STATUS primary key (ID), constraint UK1_SP_PRODUCT_STATUS unique (IDENT));

comment on table SP_PRODUCT_STATUS is 'Статус продукта';

comment on column SP_PRODUCT_STATUS.ID is 'Идентификатор';

comment on column SP_PRODUCT_STATUS.NAME is 'Наименование статуса';

comment on column SP_PRODUCT_STATUS.IDENT is 'Строковый идентификатор статуса';

/*==============================================================*/
/* Table: SP_PRODUCT_TYPE                                       */
/*==============================================================*/
create table SP_PRODUCT_TYPE (ID NUMERIC(12) not null, NAME VARCHAR(256) not null, constraint PK_SP_PRODUCT_TYPE primary key (ID));

comment on table SP_PRODUCT_TYPE is 'Тип продукта';

comment on column SP_PRODUCT_TYPE.ID is 'Идентификатор';

comment on column SP_PRODUCT_TYPE.NAME is 'Наименование типа продукта';

/*==============================================================*/
/* Table: SP_TOG_KIND                                           */
/*==============================================================*/
create table SP_TOG_KIND (ID NUMERIC(12) not null, NAME VARCHAR(256) not null, constraint PK_SP_TOG_KIND primary key (ID));

comment on table SP_TOG_KIND is 'Справочник вида одежды';

comment on column SP_TOG_KIND.ID is 'Идентификатор';

comment on column SP_TOG_KIND.NAME is 'Наименование фида одежды';

/*==============================================================*/
/* Table: TOG_PRODUCT                                           */
/*==============================================================*/
create table TOG_PRODUCT (ID NUMERIC(12) not null, KIND_ID NUMERIC(12) not null, SIZE NUMERIC(3) not null, COLOR_ID NUMERIC(12) not null, constraint PK_TOG_PRODUCT primary key (ID));

comment on table TOG_PRODUCT is 'Одежда магазина';

comment on column TOG_PRODUCT.ID is 'Идентификатор';

comment on column TOG_PRODUCT.KIND_ID is 'Идентификатор вида одежды';

comment on column TOG_PRODUCT.SIZE is 'Размер одежды';

comment on column TOG_PRODUCT.COLOR_ID is 'Идентификатор цвета';

alter table PRODUCT add constraint FK_PRODUCT_STATUS_ID foreign key (STATUS_ID) references SP_PRODUCT_STATUS (ID);

alter table PRODUCT add constraint FK_PRODUCT_TYPE_ID foreign key (TYPE_ID) references SP_PRODUCT_TYPE (ID);

alter table TOG_PRODUCT add constraint FK_TOG_PRODUCT_KIND_ID foreign key (KIND_ID) references SP_TOG_KIND (ID);

alter table TOG_PRODUCT add constraint FK_TOG_PRODUCT_COLOR_ID foreign key (COLOR_ID) references SP_COLOR (ID);

alter table TOG_PRODUCT add constraint FK_TOG_PRODUCT_ID foreign key (ID) references PRODUCT (ID) on delete cascade;

