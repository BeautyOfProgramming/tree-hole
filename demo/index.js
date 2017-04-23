document.querySelectorAll('.article-item-ask').forEach(function(item){
    item.addEventListener('click', function(){
        alert('提交成功');
    });
});

var askBtn = document.querySelector('.ask');
var askForm = document.querySelector('.ask-form');
var t = null;

askBtn.addEventListener('click', function(e){
    this.innerText = '提交咨询';
    t && clearInterval(t) && (t = null);
    t = setInterval(function(){
        if (document.body.scrollTop - 10 < 0){
            document.body.scrollTop = 0;
            clearInterval(t);
            t = null;
        } else {
            document.body.scrollTop -=10;
        }
    });
    askForm.className = askForm.className + ' ask-form-show';
});

window.addEventListener('scroll', function(){
    if (this.pageYOffset > 150 && !t){
        askBtn.innerText = '我要咨询';

        var clsIdx = askForm.className.indexOf('ask-form-show');

        if (clsIdx !== -1){
            askForm.className = askForm.className.substr(0, askForm.className.indexOf('ask-form-show'));
        }
    }
});
