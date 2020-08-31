const el = document.querySelectorAll(".move_button");

el.forEach(function(e) {
	e.addEventListener("click", update);
});


function makeRequest(method, url, data){
	httpRequest = new XMLHttpRequest();
	
	if (!httpRequest){
		alert('Cannot creat an XMLHttp instance :(');
		return false
	}
	httpRequest.onreadystatechange = function() {
		if(httpRequest.readyState === XMLHttpRequest.DONE){
			if (httpRequest.status === 200){
				console.log("success");
			}else {
				alert("failed to make a request");
			}
		}
	}
	httpRequest.open(method, url);
	httpRequest.setRequestHeader('Content-type', 'application/json');
	httpRequest.send(JSON.stringify(data));
}

function findPosition(node) {
	const parent = node.parentNode;
	for (var i in parent.childNodes) {
		if (parent.childNodes[i].nodeName === "LI"
			&& parseInt(parent.childNodes[i].dataset.id) > parseInt(node.dataset.id)) {
			return parent.childNodes[i];
		}
	}
	return null;
}

function moveCard(card){
	if(card.dataset.type ==='TODO'){
		document.querySelector('DOING').appendChild(card);
		document.querySelector('DOING').insertBefore(card, findPosition(card));
		card.dataset.type = 'DOING'
	} 
	else{
		document.querySelector('DONE').appendChild(card);
		document.querySelector('DONE').insertBefore(card, findPosition(card));
		card.dataset.type = 'DONE'
		
		for (var i in card.childNodes){
			if(card.childNodes[i].id === "move_button"){
				card.removeChild(card.childNode[i]);
			}
		}
	}
}

function update(e) {
	const target = event.target;
	const parent = target.parentNode;
	
	const data = {
		id : parent.dataset.id,
		type : parent.dataset.type
	};
	
	try {
		const msg = makeRequest('PUT', 'type', data);
		if (msg === "success"){
			moveCard(parent);
		} 
	}catch (error){
		console.log(error);
	}
}



