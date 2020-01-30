function FiltreParNom() {
    var input, filter, ul, li, h4, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        h4 = li[i].getElementsByTagName("h4")[0];
        txtValue = h4.textContent || h4.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function showAchats() {
    var y = document.getElementById("achatChoices");
    var x = document.getElementById("ventesChoices");
    if (x.style.display === "block") {
        x.style.display = "none";
    }
    if (y.style.display === "none") {
        y.style.display = "block";
    } else {
        y.style.display = "none";
    }
}

function showVentes() {
    var y = document.getElementById("ventesChoices");
    var x = document.getElementById("achatChoices");
    if (x.style.display === "block") {
        x.style.display = "none";
    }
    if (y.style.display === "none") {
        y.style.display = "block";
    } else {
        y.style.display = "none";
    }
}