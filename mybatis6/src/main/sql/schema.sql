drop procedure if exists employee_select;
create procedure employee_select()
begin
 select * from tb_employee;
end;
call employee_select();

drop procedure if exists employee_selectlike;
create procedure employee_selectlike(in p_in int,out p_out int)
begin
 select count(*) into p_out from tb_employee where gender = p_in;
end;
call employee_selectlike(1,@p_out);
select @p_out;

drop procedure if exists employee_selectall;
create procedure employee_selectall(in p_start int)
begin
	declare employees TEXT;
  select group_concat(id) into employees from tb_employee where id = p_start;
  select * from tb_employee where find_in_set(id,employees)>0;
end;
call employee_selectall(2);