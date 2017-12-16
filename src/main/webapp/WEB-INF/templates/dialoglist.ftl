<#list dialogs as dialog>
<a href="/dialogwith${dialog.sender.id}">${dialog.sender.firstName} ${dialog.sender.lastName} ${dialog.recipient.firstName} ${dialog.recipient.lastName}</a> <br>
</#list>


<#include "homebtn.ftl">