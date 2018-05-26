<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<div class="nav-side-menu">
	<div class="brand">
		<img src="https://image.ibb.co/kLkOqo/logo.png" width="50" height="50"
			class="d-inline-block align-top"
			alt="Système de gestion des absences"
			title="Système de gestion des absences">
	</div>
	<div class="menu-list">

		<ul id="menu-content" class="menu-content collapse out">
			<li><a href="<c:url value='/dashboard'/>"> <i class="fa fa-desktop fa-lg"></i>
					Dashboard
			</a></li>
			<li><a><i class="fa fa-sign-out fa-lg"></i></a></li>
			<li><a href="<c:url value='/professor/list'/>"> <i class="fa fa-user fa-lg"></i>
					Enseignants
			</a></li>
			<li><a href="<c:url value='/speciality/list'/>"> <i class="fa fa-flask fa-lg"></i>
					Spécialités
			</a></li>
			<li><a href="<c:url value='/groups/list'/>"> <i class="fa fa-users fa-lg"></i> Groupes
			</a></li>
			<li><a href="<c:url value='/subject/list'/>"> <i class="fa fa-pen-square fa-lg"></i>
					Matières
			</a></li>
			<li><a href="<c:url value='/session/list'/>"> <i class="fa fa-clock fa-lg"></i> Sessions
			</a></li>
			<li><a href="<c:url value='/classroom/list'/>"> <i class="fa fa-clipboard fa-lg"></i>
					Salles de cours
			</a></li>
			<li><a href="<c:url value='/courseSession/list'/>"> <i class="fa fa-calendar fa-lg"></i>
					Créneaux
			</a></li>
			<li><a><i class="fa fa-sign-out fa-lg"></i></a></li>
			<li><a>User : ${sessionScope.userName}</a></li>
			<li><a>Role(s) : ${sessionScope.userAuth}</a></li>
			<li><a id="logout">Se déconnecter</a></li>
		</ul>
	</div>
</div>