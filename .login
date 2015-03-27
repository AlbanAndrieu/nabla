# .login
#
# this file gets executed ONCE when the user first logs in

# construct path
setenv PATH "~/bin"
foreach i (             \
    /usr/local/bin      \
    /usr/bin            \
    /bin                \
    /usr/sbin           \
    /sbin               \
    /usr/X11R6/bin      \
)
    if ( -d "$i" ) then
        if ( -z "$path" ) then
            setenv PATH $i
        else
            setenv PATH ${PATH}:$i
        endif
    else
        echo "Warning: can't append $i to PATH because it doesn't exist."
    endif
end

# terminal options
stty -istrip            ; # allow 8-bit chars for input

# share our files with the group
umask 002

#setenv SHELL /bin/bash
#exec /bin/bash -li
