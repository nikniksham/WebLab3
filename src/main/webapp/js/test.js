function request_to_servlet() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                console.log(xhr)
                refreshFunction();
            }
        }
    }
    xhr.open('GET', '/WebLab3/test', true);
    xhr.send(null);
}


function refreshFunction(){
    $.ajax({
        url: '/WebLab3/test',  //page or method that will return html
        success: function (data) {
            
            console.log(data)
            // $('tbody#suda').html(data);
        }
    });
}

