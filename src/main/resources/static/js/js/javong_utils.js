function OnDoneButtonClick(id, userid, done) {
    pos = document.location.href.lastIndexOf('/');
    url = document.location.href.substr(0, pos);

    url = url + '/updatetodo' + '?id' + id + '&userid=' + userid +'&done' + done;

    var data = new FormData();
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function(){
    if (this.readyState === 4) {
    pos = document.location.href.lastIndexOf('/');
     url = document.location.href.substr(0, pos);
     url =url + 'todos?userid=' + userid;
     window.location=url;

    }

});

    xhr.open("POST", url);
    xhr.send(data);





}