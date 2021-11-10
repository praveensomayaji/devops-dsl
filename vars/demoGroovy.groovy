def call(body){
  def config = [:]
  body.delegate = config
  body()
  def p_mailList  = params.mailList;
  echo p_mailList
}
