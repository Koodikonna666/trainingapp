
	

var i = 0;

function duplicate() {
	var item = document.getElementById("duplicate");
    var clone = item.cloneNode(true); // "deep" clone
   // clone.id = "duplicater" + ++i;
    clone.id = "";// if the divs don't need an ID
//    original.parentNode.appendChild(clone);
    document.getElementById("event-list").appendChild(clone);

}
