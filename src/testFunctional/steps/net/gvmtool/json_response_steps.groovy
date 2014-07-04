import static cucumber.api.groovy.EN.And

And(~'^has a single result$') { ->
    assert json(response).size() == 1
}

And(~'^the first json message is "(.*)"$') { String message ->
    assert message == json(response).first().text
}

And(~'^the "([^"]*)" json message is "([^"]*)"$') { String number, String message ->
    assert json(response).get(lineOrder[number]).text == message
}

And(~'^the json message "([^"]*)" has not been received$') { String message ->
    assert !json(response).find { it.text == message }
}

And(~'^the json identifier is "(.*)"$') { int message ->
    assert json(response).id == message
}

And(~'^the json message is "(.*)"$') { String message ->
    assert json(response).text == message
}

private json(response) {
    slurper.parseText(response)
}