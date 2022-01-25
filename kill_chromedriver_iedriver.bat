@rem ***************************************************************************
@rem Copyright (c) 2018 IBM Corporation and others.
@rem All rights reserved. This program and the accompanying materials
@rem are made available under the terms of the Eclipse Public License v1.0
@rem which accompanies this distribution, and is available at
@rem http://www.eclipse.org/legal/epl-v10.html
@rem
@rem Contributors:
@rem     IBM Corporation - initial API and implementation
@rem ***************************************************************************
@echo off
rem   just kills stray local chromedriver.exe instances.
rem   useful if you are trying to clean your project, and your ide is complaining.

wmic process where name="chrome.exe" call terminate > kill_chrome.txt
wmic process where name="iexplore.exe" call terminate > kill_chrome.txt
taskkill /F /IM "chromedriver.exe"
taskkill /F /IM "IEDriver.exe"