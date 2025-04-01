function changeTextButton() {
    const clickMe = "Click Me!";
    const clickedMe = "You clicked me";
    var changeBtn = document.getElementById("changeButton");
    if (changeBtn.value == clickMe) {
        changeBtn.value = clickedMe;
        changeBtn.classList.add("green");
        changeBtn.classList.remove("red");
    } else {
        changeBtn.value = clickMe;
        changeBtn.classList.add("red");
        changeBtn.classList.remove("green");
    }
}