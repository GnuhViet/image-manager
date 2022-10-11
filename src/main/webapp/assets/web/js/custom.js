function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#imagePreview').css('background-image', 'url('+e.target.result +')');
            $('#imagePreview').hide();
            $('#imagePreview').fadeIn(650);
        }
        reader.readAsDataURL(input.files[0]);
    }
}


$("#imageUpload").change(function() {
    readURL(this);
});


let close = document.getElementsByClassName("alert-closeBtn");
let i;

for (i = 0; i < close.length; i++) {
    close[i].onclick = function(){
        let div = this.parentElement;
        div.style.opacity = "0";
        setTimeout(function(){ div.style.display = "none"; }, 600);
    }
}