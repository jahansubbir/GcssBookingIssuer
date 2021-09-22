

click(Pattern("pendingTray.png").targetOffset(0,-9))
type("o",KEY_CTRL)
wait(5)
type("abcd")
click("ok.png")
if exists("validationFailed.png"):
    click("invalidOk.png")
    wait(2)
    click("cancel.png")
else:
    msg="found"



