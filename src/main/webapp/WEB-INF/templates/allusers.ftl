
<#list users as user>
<a href="/${user.id}">${user.lastName} ${user.firstName}</a> <br>
</#list>
<#include "homebtn.ftl">
