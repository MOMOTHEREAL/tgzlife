**Description**

TGZ-Life (Tangelized Films Life Simulator) is a Bukkit 1.7.2 plugin that simulates real life into your game. It works around jobs, workers, thirst, criminals, etc.

========

**Creating a job**

First of all, you will need to create a job for players to work and recieve money on a daily basis. To create one, you will need to select 2 points that will be used for the job by using a wand. Get the wand with:

```
/job wand
```

This command will give you a Golden Axe to select the two points, just like in WorlEdit.
Next, you will need to create the job. Here is the format to use, also available with /job:

```
/job create <name> <type> <level> <description>

Permission node: tgz.life.job.create

<name> = The name of the job.
<type> = The type of the job, available types are: normal, cop, criminal. Unused in the latest build.
<level> = The level required to join the job. Number must be above 0. Unused in the latest build.
<description> = A short description of the job.
```

You now have created a job.

========

**Deleting a job**

You can also easily delete a job using the followed command:

```
/job delete <name>

Permission node: tgz.life.job.delete

<name> = The name of the job you want to delete.
```

========

**Showing info of a job**

Showing info of a specific job can be done with the following command:

```
/job info <name>

Permission node: tgz.life.job.info

<name> = The name of the job.
```

========

**Listing jobs**

You can list all the created jobs using the following command:

```
/job list

Permission node: tgz.life.job.list
```

========

**Changing the spawnpoint of a job**

When creating a job, its spawnpoint is set to the location of the creator. You can change that spawnpoint with the following command:

```
/job setspawn <name>

Permission node: tgz.life.job.setspawn

<name> = The name of the job you want to change the location of.
```
