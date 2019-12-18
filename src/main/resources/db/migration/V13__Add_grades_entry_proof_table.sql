create table grades_entry_proof
(
    gid int not null,
    proof_url varchar(255) not null,
    constraint grades_entry_proof_pk
        primary key (gid),
    constraint grades_entry_proof_grades_entry_gid_fk
        foreign key (gid) references grades_entry (gid)
            on update cascade on delete cascade
);

