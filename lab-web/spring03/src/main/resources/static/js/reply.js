/**
 * reply.js
 * 댓글관련 Ajax 기능 구현.
 * post/detail.html에 포함됨.
 */
window.addEventListener('DOMContentLoaded', () => {
    // HTML의 Document Object들이 모두 로딩이 끝난 후에 코드들이 실행될 수 있도록 하기 위해서.
    readAllReplies(); // 포스트 상세 페이지가 로딩된 후 댓글 목록 화면 출력.
    
    // btnReplayRegister 버튼을 찾고 이벤트 리스너를 등록.
    const btnReplyRegister= document.querySelector('#btnReplyRegister');
    btnReplyRegister.addEventListener('click', registerNewReply);
    
    // 댓글 작성 함수
    function registerNewReply(){
        // 포스트 글 번호 찾음.
        const postId= document.querySelector('#id').value;
        // 댓글 작성자 아이디 찾음. 
        const writer= document.querySelector('#writer').value;
        // 댓글 내용 찾음.
        const replyText= document.querySelector('#replyText').value;
        
        // 댓글 작성자와 내용은 not null.
        if(writer==''||replyText==''){
            alert('댓글을 입력하세요.');
            return;
        }
        
        // Ajax POST요청을 보낼 때 서버로 보내는 데이터 작성.
        const data= {
            postId: postId, // 댓글이 달릴 포스트 아이디(번호)
            replyText: replyText, // 댓글 내용
            writer: writer // 댓글 작성자
        }; // js에서 중괄호는 객체생성, 대괄호는 배열
        
        // Axios 라이브러리를 사용해서 Ajax POST요청을 보냄.
        axios.post('/api/reply', data) // Ajax Post 요청 보냄.
            .then(response => { // 성공 응답(response)이 도착했을 때 실행할 콜백.
                console.log(response);
                alert('#'+response.data+' 댓글이 등록되었습니다.')
                clearInputs(); // 댓글 작성자, 내용에 작성된 문자열을 삭제.
                readAllReplies(); // 댓글 목록을 다시 요청.
            })
            .catch(error => { // 실패 응답(error)이 도착했을 때 실행할 콜백.
                console.log(error);
            });
    }    
    
    function clearInputs(){
        document.querySelector('#writer').value= '';
        document.querySelector('#replyText').value= '';
    }
    
    function readAllReplies(){
        const postId= document.querySelector('#id').value;
        axios
        .get('/api/reply/all/' + postId) // Ajax Get요청 보냄.
        .then(response => {updateReplyList(response.data)})
        .catch(err => {console.log(err)});
    }
    
    function updateReplyList(data){
        // 댓글들의 배열(data)을 HTML영역에 보일 수 있도록 html코드 작성.
        const divReplies= document.querySelector('#replies');
        
        let str= ''; // div안에 들어갈 HTML코드
        for(let r of data){
            str+= '<div class="card my-2">'
                    + '<div class="card-header">'
                        +'<h5>' + r.writer + '</h5>'
                    + '</div>'
                    + '<div class="card-body">'
                        +'<p>' + r.replyText + '</p>'
                        +'<p style="font-size: 12px; margin-bottom: 0;"> 작성시간: ' + r.createdTime + '</p>'
                        +'<p style="font-size: 12px; margin-bottom: 0;"> 수정시간: ' + r.modifiedTime + '</p>'
                    + '</div>'
                    + '<div class="card-footer">'
                        + `<button type="button" class="btnModifies btn btn-outline-primary" data-rid="${r.replyId}">수정</button`
                    + '</div>'
                + '</div>'
        }
        divReplies.innerHTML= str;
        
         // [수정] 버튼들이 HTML 요소로 만들어지 이후에, [수정] 버튼에 이벤트 리스너를 등록.
        const buttons = document.querySelectorAll('.btnModifies');
        buttons.forEach(btn => {
            btn.addEventListener('click', getReply);
        });
    }
    
    
    function getReply(event) {
        //console.log(event.target); // 이벤트가 발생한 타겟 -> 버튼
        // 클릭된 버튼의 data-rid 속성값을 읽음.
        const rid = event.target.getAttribute('data-rid');
        
        // 해당 댓글 아이디의 댓글 객체를 Ajax GET 방식으로 요청.
        axios
        .get('/api/reply/' + rid)
        .then(response => { showModal(response.data) })
        .catch(err => { console.log(err) });
    }
    
    const divModal = document.querySelector('#replyModal');
    const replyModal = new bootstrap.Modal(divModal); // 부트스트랩 Modal 객체 생성.
    const modalReplyId = document.querySelector('#modalReplyId'); // 댓글 아이디 input
    const modalReplyText = document.querySelector('#modalReplyText'); // 댓글 내용 textarea
    const modalBtnDelete = document.querySelector('#modalBtnDelete'); // 댓글 삭제 버튼
    const modalBtnUpdate = document.querySelector('#modalBtnUpdate'); // 댓글 수정완료 버튼
    
    function showModal(reply) {
        // Modal 댓글 아이디/내용 채우기
        modalReplyId.value = reply.replyId;
        modalReplyText.value = reply.replyText;
        
        replyModal.show(); // 모달을 화면에 보여주기
    }
    
    modalBtnDelete.addEventListener('click', deleteReply);
    modalBtnUpdate.addEventListener('click', updateReply);
    
    function deleteReply(event) {
        const replyId = modalReplyId.value; // 삭제할 댓글 아이디
        const result = confirm('정말 삭제?');
        if (result) {
            axios
            .delete('/api/reply/' + replyId) // Ajax DELETE 요청 전송
            .then(response => {
                alert(`#${response.data} 댓글 삭제 성공`);
                readAllReplies(); // 댓글 목록 갱신
             }) // 성공(HTTP 200 OK) 응답
            .catch(err => { console.log(err) }) // 실패 응답(HTTP 40X, 50X, ...)
            .then(function(){
                // 성공 또는 실패 응답 처리가 끝났을 때 무조건 실행할 문장. like finally
                replyModal.hide(); // 모달 닫기                
            });
        }
    }
    
    function updateReply(event) {
        const replyId = modalReplyId.value; // 수정할 댓글 아이디
        const replyText= modalReplyText.value; // 수정할 댓글 내용
        if(replyText== ''){
            alert('댓글 내용은 반드시 입력');
            return;
        }
        const result= confirm('수정 완료?');
        if(result){
            const data= {replyText: replyText};
            axios
            .put('/api/reply/'+ replyId, data)
            .then(response=> {
                alert(`#${response.data} 댓글 수정 성공`);
                readAllReplies();
            })
            .catch(err=> {console.log(err)})
            .then(function(){
                replyModal.hide();
            })
        }
    }
});