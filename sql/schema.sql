create schema LEP;

create table LEP.COMPOSES
(
    ID serial
        constraint table_name_pk
            primary key,
    NCAS text not null,
    NCE text not null,
    NAME text,
    DESCRIPTION text
);

create unique index table_name_ncas_uindex
    on LEP.COMPOSES (NCAS);

create unique index table_name_nce_uindex
    on LEP.COMPOSES (NCE);

comment on table LEP.COMPOSES is 'Chemical composes';