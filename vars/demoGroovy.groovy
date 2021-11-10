def call(body){
  def config = [:]
  body.delegate = config
  body()
  def p_mailList  = config.mailList;
  echo p_mailList
}
