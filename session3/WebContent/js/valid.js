function checkValid()
{
	var message = "";
	var flag = true;

	if(!checkAge()){
		message = message + 'please enter a valid age\n';
		flag = false;
	}
	
	if(!checkFirstName()){
		message = message + 'please enter a valid First Name\n';
		flag = false;
	}
	
	if(!checkFirstName()){
		message = message + 'please enter a valid Last Name\n';
		flag = false;
	}



	if(flag){
		document.getElementById('add_employee').submit();
	}else{
		alert(message);
	}

}

function checkAge(){
	var pattern = new RegExp("^[0-9]{1,2}$");
	var age = document.getElementById('age').value;
	return pattern.test(age);
}

function checkFirstName(){
	var pattern = new RegExp("^[A-Za-z'_]+$");
	var firstName = document.getElementById('first_name').value;
	return pattern.test(firstName);
}

function checkFirstName(){
	var pattern = new RegExp("^[A-Za-z'_]+$");
	var lastName = document.getElementById('last_name').value;
	return pattern.test(lastName);
}


